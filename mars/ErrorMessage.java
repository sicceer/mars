package mars;

/*
Copyright (c) 2003-2006,  Pete Sanderson and Kenneth Vollmar

Developed by Pete Sanderson (psanderson@otterbein.edu)
and Kenneth Vollmar (kenvollmar@missouristate.edu)

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
"Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject 
to the following conditions:

The above copyright notice and this permission notice shall be 
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

(MIT license, http://www.opensource.org/licenses/mit-license.html)
 */

/**
 * Represents occurrance of an error detected during tokenizing, assembly or simulation.
 * @author Pete Sanderson
 * @version August 2003
 **/

public class ErrorMessage {
   private boolean isWarning; // allow for warnings too (added Nov 2006)
   private String filename; // name of source file  (added Oct 2006)
   private int line;     // line in source code where error detected
   private int position; // position in source line where error detected
   private String message;
   
	/**
	 *  Constant to indicate this message is warning not error
	 */
   public static final boolean WARNING = true;
	
	/**
	 *  Constant to indicate this message is error not warning
	 */
	public static final boolean ERROR = false;
	
   /**
    * Constructor for ErrorMessage.
	 * @param filename String containing name of source file in which this error appears.
    * @param line Line number in source program being processed when error occurred.
    * @param position Position within line being processed when error occurred.  Normally is starting
    * position of source token.
    * @param message String containing appropriate error message.
    **/
	 // Added filename October 2006
    
   public ErrorMessage(String filename, int line, int position, String message) {
	   this(ERROR, filename, line, position, message);
   }

   /**
    * Constructor for ErrorMessage.
	 * @param isWarning set to WARNING if message is a warning not error, else set to ERROR or omit.
	 * @param filename String containing name of source file in which this error appears.
    * @param line Line number in source program being processed when error occurred.
    * @param position Position within line being processed when error occurred.  Normally is starting
    * position of source token.
    * @param message String containing appropriate error message.
    **/
    
   public ErrorMessage(boolean isWarning, String filename, int line, int position, String message) {
	   this.isWarning = isWarning;
	   this.filename = filename;
      this.line = line;
      this.position = position;
      this.message = message;
   }


   /**
    * Constructor for ErrorMessage.
	 * @param sourceMIPSprogram MIPSprogram object of source file in which this error appears.
    * @param line Line number in source program being processed when error occurred.
    * @param position Position within line being processed when error occurred.  Normally is starting
    * position of source token.
    * @param message String containing appropriate error message.
    **/
    
   public ErrorMessage(MIPSprogram sourceMIPSprogram, int line, int position, String message) {
	   this(ERROR, (sourceMIPSprogram==null) ? "" : sourceMIPSprogram.getFilename(), line, position, message);
   }

 /**
    * Constructor for ErrorMessage.
	 * @param isWarning set to WARNING if message is a warning not error, else set to ERROR or omit.
	 * @param sourceMIPSprogram MIPSprogram object of source file in which this error appears.
    * @param line Line number in source program being processed when error occurred.
    * @param position Position within line being processed when error occurred.  Normally is starting
    * position of source token.
    * @param message String containing appropriate error message.
    **/
    
   public ErrorMessage(boolean isWarning, MIPSprogram sourceMIPSprogram, int line, int position, String message) {
	   this(isWarning, (sourceMIPSprogram==null) ? "" : sourceMIPSprogram.getFilename(), line, position, message);
   }


   /**
    * Produce name of file containing error.
    * @return Returns String containing name of source file containing the error.
    */
   // Added October 2006
	
   public String getFilename() {
      return filename;
   }
   
   /**
    * Produce line number of error.
    * @return Returns line number in source program where error occurred.
    */
   
   public int getLine() {
      return line;
   }

   /**
    * Produce position within erroneous line.
    * @return Returns position within line of source program where error occurred.
    */
   
   public int getPosition() {
      return position;
   }
   
   /**
    * Produce error message.
    * @return Returns String containing textual error message.
    */
   
   public String getMessage() {
      return message;
   }
	
	/**
    * Determine whether this message represents error or warning.
    * @return Returns true if this message reflects warning, false if error.
    */
	 // Method added 28 Nov 2006
	public boolean isWarning() {
	   return this.isWarning;
	}
}  // ErrorMessage