/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializabledeserializeexample;

import java.io.EOFException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializableDeserializeExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, EOFException, ClassNotFoundException {
        /**
         * serialize (write) the object to a binary text file.
         * serializable is implemented in the Student class
         * 'public class Student implements serializable'
         */
        
        //Create an example Array list of student objects.
        ArrayList<Student> sl = new ArrayList<>();
        sl.add(new Student("Jake", 4.2));
        sl.add(new Student("Jennifer", 3.8));
        sl.add(new Student("Jace", 5.0));
        
        //Save the file to binary text file named students.txt
        File file = new File("studentsList.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //write all of the objects with an enhanced for loop.
        for(Student s: sl){
            oos.writeObject(s);
        }
        
        //**Important Always close the streams**
        fos.close();
        oos.close();
        
        /**
         * Retreive (read) the data student objects back.
         */
        
        //reads the data back in.
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        //new Array list to add students back to.
        ArrayList<Student> returnSL = new ArrayList<>();
        
        //** Required try and catch block while loop to promote student objects back.
        try{
            while(true){
                
                Student rsl = (Student) ois.readObject();
                returnSL.add(rsl);
            }
            
        }catch(EOFException eofex){}
        
        //read back to screen to confirm student object retrievement.
        for(Student confirm: returnSL){
            System.out.println(confirm);
        }
        
        
    }
    
    
}//End class.
