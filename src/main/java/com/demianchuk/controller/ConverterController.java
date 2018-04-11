package com.demianchuk.controller;

import com.demianchuk.checker.NumeralChecker;
import com.demianchuk.converter.NumeralConverter;
import com.demianchuk.view.ConverterView;

import javax.swing.*;
import java.awt.event.*;

public class ConverterController {
    protected ConverterView view;
    private NumeralChecker checker;
    private NumeralConverter converter;


    public ConverterController(ConverterView view, NumeralChecker checker,
                               NumeralConverter converter) {
        this.view = view;
        this.checker = checker;
        this.converter = converter;
    }

    protected boolean isEnter(KeyEvent evt) {
        return evt.getKeyCode() == 10;
    }

    protected void performAction(JTextField from, JTextField to) {
        String value = from.getText().toUpperCase();
        try {
            if (checker.isLegalNumeral(value))
                to.setText(converter.convert(value));
        } catch (Exception e) {
            //TODO
        }
    }
}