/*
 * Copyright (C) 2015 wolf
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package chat;

/**
 *
 * @author wolf
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Chat {
private static final int PORTNUM = 9980;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{String hostIP = new String("127.0.0.1");
            Socket serverCon = new Socket(hostIP,PORTNUM);
            PrintWriter out = new PrintWriter(serverCon.getOutputStream(),true);
            Scanner in = new Scanner(serverCon.getInputStream());
            Scanner userIn = new Scanner(System.in);
            hammingCoder hammingcoder = new hammingCoder();
            hammingcoder.encode(userIn.nextLine());
            while(true){  
             if(in.hasNext()){   
            System.out.println("echo:	" + in.nextLine());
             }
            out.println(userIn.nextLine());
            }
            } catch(Exception e){
        }
 
        
    }
    
}
