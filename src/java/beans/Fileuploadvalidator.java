/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author sebatsian
 */
@FacesValidator(value="fileUploadValidator")
public class Fileuploadvalidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        Part file = (Part) t;
 
        FacesMessage message1=null;
        System.out.println("file type:"+file.getContentType().endsWith("jpeg"));
        
        if(!file.getContentType().endsWith("jpeg"))
        {
            message1=new FacesMessage("select jpg");
        }
 
//        try {
//            
//             if (!file.getContentType().endsWith("jpeg") || !file.getContentType().endsWith("png"))
//                message1=new FacesMessage("Select jpg file");
////            else if (file.getSize()>2000000)
////                 message1=new FacesMessage("File size too big. File size allowed  is less than or equal to 2 MB.");
// 
            if (message1!=null && !message1.getDetail().isEmpty())
                {
                    message1.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message1);
                }
//// 
//        } catch (Exception ex) {
//               throw new ValidatorException(new FacesMessage(ex.getMessage()));
//        }
    }
    
}
