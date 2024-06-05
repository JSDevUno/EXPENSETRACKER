/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EP;

/**
 *
 * @author Windows 10
 */
public class UserSession {
    private static Integer userID;

    public static Integer getUserID() {
        return userID;
    }

    public static void setUserID(Integer userID) {
        UserSession.userID = userID;
    }
}
