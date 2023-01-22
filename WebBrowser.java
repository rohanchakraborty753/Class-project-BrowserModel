/**
 * imports java module .util and .net
 */

import java.util.*;
import java.net.*;

/**
 * creates a class WebBrowser
 */

public class WebBrowser{

    /**
     *   initializes recent as a String
     *   initializes bookmarklist as a String
     *   initializes WebBrowser as a StackInt of type Object
     *   initializes recentpage, forwardpage, backpage as a StackInt of type String
     *   initializes bookmarks as ArrayList
     */
     private StackInt<Object> WebBrowser;
     private StackInt<String> recentpage = new LinkedStack<String>();
     private StackInt<String> backpage = new LinkedStack<String>();
     private StackInt<String> forwardpage = new LinkedStack<String>();
     private StackInt<String> History = new LinkedStack<String>();
     private List<String> bookmarks = new ArrayList<String>();
     private String recent = "";
     private String bookmarklist = "";


    /**
     * Creates a constructor without argument
     */
     public WebBrowser(){
         load("http://www.ulm.edu");
        
     }

    /**
     *
     * @param url takes url as an argument
     */
    public WebBrowser(String url){
       load(url);
     }

    /**
     *
     * @param url takes url as a parameter
     * @return executes statements of true block when true or returns statements of false block when false
     */
     public boolean load(String url){
    
      try{
          URL webpage = new URL(url);
          if(webpage.getContent() != null){
            recent = url;
            recentpage.push(url);
            History.push(url);
            return true;
          }              
                 
        }
       catch(Exception e){
            
            recent = "ERROR: CANNOT FIND " + url;
            recentpage.push(recent);
        }
        
        return false;
        
      }

    /**
     *
     * @return returns the currentpage
     */
    public String currentPage(){
     
     return recent;
     
     }

    /**
     *
     * @return returns the page one step back from the currentpage
     */
    public String goBack(){
     
     if(!recentpage.empty()){
     
     forwardpage.push(recentpage.pop());
     if(recentpage.empty())
     {
     recentpage.push(forwardpage.pop());
     recent = recentpage.peek();
     return recent;
     
     }else
     
     {
 
     recent = recentpage.peek();
     return recent;
     }
     
    }else
      return recent;
     
   }

    /**
     *
     * @return returns the page one step forwards from the currentpage
     */
    public String goForward(){
    
        if(!forwardpage.empty()){
    
     backpage.push(forwardpage.pop());
     recent = backpage.peek();
     recentpage.push(backpage.pop());
     return recent;
     
     }else
     
     {
     recent = recentpage.peek();
     return recent;
     }
     
    }

    /**
     *
     * @return returns all the pages that loaded succcessfully as history
     */
    public String history(){
     
     String his = "\nHistory:" + "\n";
     StackInt<String> temp  = new LinkedStack<String>();
     
     while(!History.empty()){
     his += temp.push(History.pop()) + "\n";
     }
     while(!temp.empty()){
     History.push(temp.pop());
     }
     return his;
     }


    /**
     *
     * @return returns false if the currentpage is already bookmarked else returns true and bookmarks it
     */
    public boolean bookmark(){
     
           if(bookmarks.contains(currentPage())){
              return false;
            }else{
              bookmarks.add(currentPage());
              return true;
            }      
  }

    /**
     *
     * @return returns all the pages that were bookmarked line by line
     */
    public String getBookmarks(){

          for(String list : bookmarks)
          bookmarklist += list + "\n";
          return "\nBookmark:\n" + bookmarklist;
     
     }

}
