/* 
 * The MIT License
 *
 * Copyright 2019 Mani Moayedi (acidmanic.moayedi@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.acidmanic.pactmodels;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ConventionedContract extends Contract{
    
    
    private String serviceName;
    
    private String apiName;

    public ConventionedContract() {
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ConventionedContract(Contract contract) {
        
        this.setConsumer(contract.getConsumer());
        
        this.setInteractions(contract.getInteractions());
        
        this.setMetadata(contract.getMetadata());
        
        this.setProvider(contract.getProvider());
    }
    
    
    @Override
    public void setProvider(Provider provider) {
        super.setProvider(provider);
        
        this.serviceName = null;
        this.apiName = null;
        
        String pname = provider.getName();
        
        if (pname==null){
            return ;
        }
        
        String[] parts = pname.split("-");
        
        if(parts.length!=2){
            return ;
        }
        
        this.serviceName = parts[0];
        
        this.apiName = parts[1];
        
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getApiName() {
        return apiName;
    }
    
    
    public static ConventionedContract load(String path) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
    
        ConventionedContract contract = objectMapper.readValue(new File(path), ConventionedContract.class);
    
        return contract;
    }
}
