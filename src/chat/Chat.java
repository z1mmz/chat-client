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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chat {

    private static final int PORTNUM = 9980;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String hostIP = new String("127.0.0.1");
            ArrayList<int[]> hammingCodes = new ArrayList<int[]>();
            Socket serverCon = new Socket(hostIP, PORTNUM);
            PrintWriter out = new PrintWriter(serverCon.getOutputStream(), true);
            Scanner in = new Scanner(serverCon.getInputStream());
            Scanner userIn = new Scanner(System.in);
            hammingCoder hammingcoder = new hammingCoder();
            hammingCodes = hammingcoder.encode(userIn.nextLine());
            while (true==true) {
//               if (in.hasNext()) {
//                    System.out.println("echo:	" + in.nextLine());
//                     System.out.println("LOOPY");
//                }
                hammingCodes = hammingcoder.encode(userIn.nextLine());
                for (int i = 0; i < hammingCodes.size();i++){
                    int[] tempHamming = hammingCodes.get(i);
//                   if( tempHamming[2] == 0){
//                   tempHamming[2] =1;
//                   } else{
//                   tempHamming[2] = 0;
//                   }//mess up the hamming!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                   String strHamming = Arrays.toString(tempHamming);
                   strHamming = strHamming.replaceAll("\\[*\\]*\\,*", "").replaceAll("\\s*", "");
                    System.out.println("sadadas  "+strHamming);
                    out.println(strHamming);
                }
//                 System.out.println("LOOPY");
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
System.out.println("END");
    }

}
