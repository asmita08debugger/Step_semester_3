package main.java.oop_inheritance.assignment_problems;
public class MembershipFieldReachChecker 
{
    static String classifyAccess(String fieldModifier, String accessorContext) 
    {
        if (fieldModifier.equals("private")) 
        {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default") || fieldModifier.equals("protected")) 
        {
            return accessorContext.equals("DIFFERENT_PACKAGE")? "DENIED" : "ALLOWED";
        }
        if (fieldModifier.equals("public")) 
        {
            return "ALLOWED";
        }
        return "DENIED";
    }
    static String summarizeByModifier(String[][] attempts) 
    {
        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;
        for (int i = 0; i < attempts.length; i++) 
        {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(modifier, context);
            if (modifier.equals("private")) 
            {
                if (result.equals("ALLOWED")) 
                    privateAllowed++;
                else 
                    privateDenied++;
            } 
            else if (modifier.equals("default")) 
            {
                if (result.equals("ALLOWED")) 
                    defaultAllowed++;
                else 
                    defaultDenied++;
            } 
            else if (modifier.equals("protected")) 
            {
                if (result.equals("ALLOWED"))
                    protectedAllowed++;
                else 
                    protectedDenied++;
            } 
            else if (modifier.equals("public")) 
            {
                if (result.equals("ALLOWED")) 
                    publicAllowed++;
                else 
                    publicDenied++;
            }
        }
        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied | " + "default: " + defaultAllowed + " allowed / " + defaultDenied + " denied | " + "protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied | " + "public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }
    public static void main(String[] args) 
    {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        String[][] attempts = {{"private", "SAME_CLASS"},{"private", "SAME_PACKAGE"},{"default", "SAME_PACKAGE"},{"default", "DIFFERENT_PACKAGE"},{"protected", "SAME_PACKAGE"},{"protected", "SAME_CLASS"},{"public", "DIFFERENT_PACKAGE"}};
        System.out.println(summarizeByModifier(attempts));
        try 
        {
            new LibraryMember("LB9", "BR1", 0, "Priya Nair");
            System.out.println("construction succeeded");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("construction rejected");
        }
        new LibraryMember("LB94", "BR1", 0, "Priya Nair");
        System.out.println("LB94 construction succeeded");
    }
}
class LibraryMember 
{
    private String membershipId;
    String branchCode;
    protected double finesOwed;
    public String displayName;
    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) 
    {
        membershipId = membershipId.trim();
        if (membershipId.isEmpty() || membershipId.length() < 4) 
        {
            throw new IllegalArgumentException("Invalid membership ID");
        }
        this.membershipId = membershipId;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}