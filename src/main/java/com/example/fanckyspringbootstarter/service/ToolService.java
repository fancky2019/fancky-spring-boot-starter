package com.example.fanckyspringbootstarter.service;

import com.example.fanckyspringbootstarter.config.FanckyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {
    @Autowired
    FanckyTest fanckyTest;

    public String CommonFun()
    {
        return fanckyTest.getHost();
    }
}
