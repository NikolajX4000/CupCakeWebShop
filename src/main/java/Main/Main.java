/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DBConnection.DAO;
import Data.OrderLine;

/**
 *
 * @author Stephan
 */
public class Main
{
    public static void main(String[] args)
    {
        DAO dao = new DAO();
        
        for (OrderLine ol : dao.getOrder(1).getOrder()) {
            System.out.println(ol);
        }
        
    }
}
