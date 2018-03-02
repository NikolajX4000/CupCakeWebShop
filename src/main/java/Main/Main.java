package Main;

import DBConnection.DAO;

public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.withdrawal(1, 46));
    }
}
