/**
   Execution engine for three-address code programs. Minimal
   error detection.
     
   Syntax:
      x := y op z;
      x := y;
      read x;
      write x;
      if ( x == 0 ) goto l;  
      if (x != 0 ) goto l;
      goto l;
      l:
      halt;
      # This is a comment

   Notes:
   1) Symbol := denotes assignment
   2) Instructions terminated by semicolons
   3) Identifiers: alphanumeric strings, beginning with letter; case sensitive
   4) Jump labels: as above; must be unique; no terminating semicolon
   5) Comments: begin with #, extend to end of line


   @author Kieran Herley, Nov 2011
*/

import java.util.*;

public class TacExecutionEngine
{
   //final class variables 
   private static final int TRUE = 1;
   private static final int FALSE = 0;
   
   /* The instructions comprising this program */
   private TacProgram2 program;

   /* Insert declarations of other data stucrures here */
   private ArrayBasedMap<String, Integer> variableMap;
   private ArrayBasedMap<String, Integer> labelMap;
   
   /* Input source */
   private Scanner input;
   
   

   /**
      Create this (initially empty) program.
   */
   public TacExecutionEngine(TacProgram2 prog)
   {  program = prog;

      /* Initialize other data structures here */
 
      input = new Scanner(System.in);
      variableMap = new ArrayBasedMap<>();
      labelMap = new ArrayBasedMap<>();
   }


   /**
      Execute this program.
   */
   public void execute()
   {  
   
      //loop through the program continuously to get the location of all the labels  
      for(int i =0; i < program.size(); i++){
          TacInstruction2 instruction = program.get(i);
          TacInstruction2.InstructionKind kind = instruction.getKind(); 
          if(kind == TacInstruction2.InstructionKind.LABEL){
              if(labelMap.get( instruction.getLabel() ) != null){
                  System.out.println(instruction.getLabel() + " Label already in use");
              }else{
                  labelMap.put(instruction.getLabel() , i);
              }
          }
      }
      
      //carry out the instructions and move around the code as appropriate 
      int counter =0;
      while( counter < program.size() ){
          //do it instruc
          TacInstruction2 instruction = program.get(counter);
          TacInstruction2.InstructionKind kind = instruction.getKind();
          if(kind == TacInstruction2.InstructionKind.HALT){
              counter = program.size();
          }else if(kind == TacInstruction2.InstructionKind.READ){
              int read = input.nextInt();
              variableMap.put( instruction.getAddr1(), read);
          }else if(kind == TacInstruction2.InstructionKind.WRITE){
              System.out.println(isNumber(instruction.getAddr1()) ?  Integer.parseInt(instruction.getAddr1()) : variableMap.get(instruction.getAddr1()));	
          }else if(kind == TacInstruction2.InstructionKind.TWOADDR){
              variableMap.put( instruction.getAddr1(), 
                              isNumber(instruction.getAddr2()) ?  Integer.parseInt(instruction.getAddr2()) : variableMap.get(instruction.getAddr2()));
          }else if(kind == TacInstruction2.InstructionKind.JUMPTRUE){
              if(variableMap.get(instruction.getAddr1()) == TRUE){
                  counter = labelMap.get(instruction.getLabel());
              }
          }else if(kind == TacInstruction2.InstructionKind.JUMPFALSE){
              if(variableMap.get(instruction.getAddr1()) == FALSE){
                  counter = labelMap.get(instruction.getLabel());
              }
          }else if(kind == TacInstruction2.InstructionKind.GOTO){
              counter = labelMap.get(instruction.getLabel());
                          
          }else if(kind == TacInstruction2.InstructionKind.THREEADDR){
              String operator = instruction.getOp();
              int addr3 = isNumber(instruction.getAddr3()) ?  Integer.parseInt(instruction.getAddr3()) : variableMap.get(instruction.getAddr3());
              int addr2 = isNumber(instruction.getAddr2()) ?  Integer.parseInt(instruction.getAddr2()) : variableMap.get(instruction.getAddr2());
              int answer = 0;
              
              switch(operator){
                  case "*":
                       answer = addr2 * addr3;
                       break;
                  case "<":
                       answer = addr2 < addr3 ? TRUE : FALSE;
                       break;
                  case ">":
                       answer = addr2 > addr3 ? TRUE : FALSE;
                       break;
                  case "/":
                       answer = addr2 / addr3;
                       break;
                  case "+":
                       answer = addr2 + addr3;
                       break;
                  case "-":
                       answer = addr2 - addr3;
                       break;
                  case "==":
                       answer = addr2 == addr3 ? TRUE : FALSE;
                       break;
                  case "!=":
                       answer = addr2 != addr3 ? TRUE : FALSE;
                       break;
                  case "<=":
                       answer = addr2 <= addr3 ? TRUE  : FALSE;
                       break;
                  case ">=":
                       answer = addr2 >= addr3 ? TRUE : FALSE;
                       break;
              }
              variableMap.put( instruction.getAddr1(), answer);
          }
          counter++;
      }
   }

   /**
   * check if the variable is a number
   */
   private boolean isNumber(String var){
       try  
       {  
           Integer d = Integer.parseInt(var);  
       }  
       catch(NumberFormatException nfe)  
       {  
           return false;  
       }  
       return true; 
    }



   public static void main(String args[])
   {  System.out.println("TacExecutionEngine v1.0: KTH 11/11/'11");
      System.out.println("Beta version");
      if (args.length < 1 )
      {  System.err.println("Usage: java TacExecutionEngine filename");
         System.exit(1);
      } 
      String sourceFile = args[0];

      /* Scan source file and creat TAC program */
      TacScanner2 scanner = new TacScanner2(sourceFile);
      TacProgram2 prog = scanner.scan();
      System.out.println("*** Scanning complete; execution commencing ***");

      /* Create execution environment and execute program */
      TacExecutionEngine engine = new TacExecutionEngine(prog);
      engine.execute();     
      System.out.println("*** Execution complete                      ***");
   }




}