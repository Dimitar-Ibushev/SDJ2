package controller;

import java.util.Observable;
import java.util.Observer;

import view.*;
import domain.mediator.Model;
import domain.mediator.ModelClient;
import domain.model.Message;

public class ClientController implements Controller
{
   private ModelClient model;
   private MainGUI view;

   public ClientController(ModelClient model, MainGUI view)
   {
      this.model = model;
      this.view = view;
      ((Observable) this.model).addObserver((Observer) view);
   }

   @Override
   public void execute(String what) throws Exception
   {
      System.out.println(what);
      switch (what)
      {
         case "Send":

            System.out.println(view.activeGUI());
            String input = view.getMessage();

            if (input.length() > 0)
            {
               model.addMessageInModel(new Message(input));
               model.addMessage(new Message(input), view
                     .getUssernameFromLogIn(), model
                     .getIdForUserFromDatabase(view.getUssernameFromLogIn()));

               System.out.println(input);
            }
break;
         case "Log in":

            String name = view.getUssernameFromLogIn();
            String pass = view.getPasswordFromLogIn();

            if (model.testUser(name, pass))
            {
               view.LogInUser();
            }
            else if (model.testAdmin(name, pass))
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

      }

   }

}
