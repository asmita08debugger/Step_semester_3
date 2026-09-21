package main.java.inherit_polymorphism.assignment_problems;
public class RaceSettlement 
{
    static class RaceEntry 
    {
        private static int bibCounter = 0;
        protected double balanceDue;
        private final String entryCode;
        public RaceEntry(String bibNumber, double entryFee) 
        {
            this.entryCode = "RACE-" + (++bibCounter);
            this.balanceDue = entryFee;
        }
        public void pay(double amount) 
        {
            balanceDue -= amount;
        }
        public void pay(double amount, String mode) 
        {
            System.out.println("Paying via " + mode);
            pay(amount);
        }
        public static boolean isValidDiscountCode(String code) 
        {
            if (code == null || code.length() != 5) 
            {
                return false;
            }
            if (code.charAt(0) != 'M') 
            {
                return false;
            }
            if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2)) || !Character.isDigit(code.charAt(3))) 
            {
                return false;
            }
            return Character.isUpperCase(code.charAt(4));
        }
        public static int getBibCounter() 
        {
            return bibCounter;
        }
        public static String settleNight(RaceEntry[] entries) 
        {
            int processed = 0;
            int nullSkipped = 0;
            int relay = 0;
            int individual = 0;
            for (RaceEntry entry : entries) 
            {
                if (entry == null) 
                {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (entry instanceof RelayTeamEntry) 
                {
                    relay++;
                } 
                else 
                {
                    individual++;
                }
            }
            return processed + " processed | " + nullSkipped + " null skipped | " + relay + " relay | " + individual + " individual";
        }
    }
    static class EliteRunnerEntry extends RaceEntry 
    {
        public EliteRunnerEntry(String bibNumber, double entryFee) 
        {
            super(bibNumber, entryFee);
        }
    }
    static class RelayTeamEntry extends RaceEntry 
    {
        public RelayTeamEntry(String bibNumber, double entryFee) 
        {
            super(bibNumber, entryFee);
        }
    }
    public static void main(String[] args) 
    {
        EliteRunnerEntry elite = new EliteRunnerEntry("BIB3001", 150);
        RelayTeamEntry relay = new RelayTeamEntry("BIB4001", 300);
        elite.pay(10, "UPI");
        System.out.println(RaceEntry.isValidDiscountCode("M123A"));
        System.out.println(RaceEntry.isValidDiscountCode("M12A"));
        System.out.println(RaceEntry.isValidDiscountCode("X123A"));
        RaceEntry[] entries = {elite, null, relay};
        System.out.println(RaceEntry.settleNight(entries));
        System.out.println("Bib counter: " + RaceEntry.getBibCounter());
    }
}