package com.mygwt.mymvn.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	E:/Java/Libs/maven/bin/src/main/resources/com/mygwt/mymvn/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
