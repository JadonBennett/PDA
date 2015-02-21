package com.mrjaffesclass.apcs.mvc.template;
import com.mrjaffesclass.apcs.messenger.*;
/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {
  // Messaging system for the MVC
  private final Messenger mvcMessaging;
  // Model's data variables
  private int lower;
  private int upper;
  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    mvcMessaging.subscribe("view:ageInput:model", this);
  }
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("RCV (model): "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("RCV (model): "+messageName+" | No data sent");
    }
    MessagePayload payload = (MessagePayload)messagePayload;
    
    int field = payload.getField();
    int direction = payload.getDirection();
 
    
  }
  /**
   * Getter function for variable 1
   * @return Value of variable1
   */
  public int getLower() {
    return lower;
  }
  /**
   * Setter function for variable 1
   * @param age New value of variable1
   */
  public void setLower(int age) {
    lower = age/2 + 7;
    mvcMessaging.notify("model:lowerOfficial:view", lower, true);
  }
  /**
   * Getter function for variable 1
   * @return Value of variable2
   */
  public int getUpper() {
    return upper;
  }
  /**
   * Setter function for variable 2
   * @param age New value of variable 2
   */
  public void setUpper(int age) {
    upper = (age-7)*2;
    mvcMessaging.notify("model:upperOfficial:view", upper, true);
  }
}