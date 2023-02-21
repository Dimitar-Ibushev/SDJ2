package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import view.LogIn;
import view.MainGUI;
import domain.mediator.Model;
import domain.mediator.ModelClient;
import domain.model.Message;

public class AdminController implements Controller
{
      private Model model;
      private MainGUI view;

      public AdminController(Model model, MainGUI view)
      {
         this.model = model;
         this.view = view;
         ((Observable) this.model).addObserver((Observer)view);
      }
      
      @Override
      public void execute(String what) throws Exception
      {
         System.out.println(what);
         switch (what)
         {
            case "Send":

               System.out.println(view.activeGUI());
               String input = view.getMessageAdmin();

               if (input.length() > 0)
               {
                  model.addMessageInModel(new Message(input));
                  model.addMessageAdmin(new Message(input), view
                        .getUssernameFromLogIn(), model
                        .getIdForAdminFromDatabase(view.getUssernameFromLogIn()));

                  System.out.println(input);
               }
break;
            case "Log in":

               String name = view.getUssernameFromLogIn();
               String pass = view.getPasswordFromLogIn();

               System.out.println("name : " + name + "  pass:  " + pass);
               
               if (model.testUser(name, pass))
               {
            	   JOptionPane.showMessageDialog(null, " Please type Administrator credentials !!!");
               }
                if (model.testAdmin(name, pass))
               {
                  view.LogInAdmin();
               
               }
break;
            case "Log out":
            	view.LogOut();
            	break;
            case "Edit":
            case "Delete":
            case "Show history":
            case "Create":
            	 String Newname = view.getNewUssernameCreate();
                 String Newpass =view. getNewPasswordCreate();
                 
            	System.out.println("NAME: " + Newname + "  Pass: " + Newpass);
                 if(!(Newname == null) && !(Newpass== null))
                 {
                 model.createUser(Newname, Newpass);
                 }
                 break;
         }

      }

   }
  

