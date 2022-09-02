package com.sample.servlet;
 import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.core.io.ClassPathResource;

import com.sample.model.Image;
import com.sample.service.ImageService;
import com.sample.service.ImageServiceImpl;

/**
 * Servlet to handle File upload request from Client
 */
public class FileUploadServlet extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String name = "";
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        item.write( new File(getUploadDir() + File.separator + name));
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
               
               //Saving Image
               Image i = new Image();
               i.setImageName(name);
               ImageService service = new ImageServiceImpl();
               service.saveImage(i);
               
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
             
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
        
        response.sendRedirect(request.getContextPath() + "/index.html");
     
    }
  
    private String getUploadDir() {
    	String uploadDir = null;
    	InputStream in = null;
    	try{
    		in = new ClassPathResource("database.properties").getInputStream();
    		Properties prop = new Properties();

    		prop.load(in);
    		uploadDir = prop.getProperty("upload.dir");
    	} 
    	catch (IOException e) {

    		e.printStackTrace();
    	} finally {
    		if(in != null)
    			try {
    				in.close();
    			} catch (IOException e) {
    				//do nothing
    			}
    	}
    	return uploadDir;
    }
}