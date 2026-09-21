package main.java.inherit_polymorphism.assignment_problems;
public class RaceFamilyDemo 
{
    static class RaceEntry 
    {
        protected String bibNumber;
        protected double balanceDue;
        public RaceEntry(String bibNumber, double entryFee) 
        {
            this.bibNumber = bibNumber;
            this.balanceDue = entryFee;
        }
        public double getBalanceDue() 
        {
            return balanceDue;
        }
        public void announce() 
        {
            System.out.println("Race Entry | Bib: " + bibNumber + " | Balance: " + balanceDue);
        }
    }
    static class RunnerEntry extends RaceEntry 
    {
        protected String category;
        public RunnerEntry(String bibNumber, double entryFee, String category) 
        {
            super(bibNumber, entryFee);
            this.category = category;
        }
        @Override
        public void announce() 
        {
            System.out.println("Runner Entry | Bib: " + bibNumber + " | Category: " + category + " | Balance: " + balanceDue);
        }
    }
    static class EliteRunnerEntry extends RunnerEntry 
    {
        private double sponsorBonus;
        public EliteRunnerEntry(String bibNumber, double entryFee, String category, double sponsorBonus) 
        {
            super(bibNumber, entryFee, category);
            this.sponsorBonus = sponsorBonus;
        }
        @Override
        public void announce() 
        {
            System.out.println("Elite Runner | Bib: " + bibNumber + " | Category: " + category + " | Sponsor Bonus: " + sponsorBonus + " | Balance: " + balanceDue);
        }
    }
    static class RelayTeamEntry extends RaceEntry 
    {
        private int teamSize;
        public RelayTeamEntry(String bibNumber, double entryFee, int teamSize) 
        {
            super(bibNumber, entryFee);
            this.teamSize = teamSize;
        }
        @Override
        public void announce() 
        {
            System.out.println("Relay Team | Bib: " + bibNumber + " | Team Size: " + teamSize + " | Balance: " + balanceDue);
        }
        public int getTeamSize() 
        {
            return teamSize;
        }
    }
    static String classifyGeneration(RaceEntry entry) 
    {
        if (entry instanceof EliteRunnerEntry) 
        {
            return "Multilevel descendant";
        }
        if (entry instanceof RelayTeamEntry) 
        {
            return "Hierarchical sibling";
        }
        return "Base generation";
    }
    static double getTotalBalanceDue(RaceEntry[] entries) 
    {
        double total = 0;
        for (RaceEntry entry : entries) 
        {
            total += entry.getBalanceDue();
        }
        return total;
    }
    public static void main(String[] args) 
    {
        RunnerEntry runner = new RunnerEntry("BIB2001", 80, "Open 10K");
        EliteRunnerEntry elite = new EliteRunnerEntry("BIB3001", 150, "Elite Full Marathon", 500);
        RelayTeamEntry relay = new RelayTeamEntry("BIB4001", 300, 4);
        runner.announce();
        elite.announce();
        relay.announce();
        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(relay));
        RaceEntry[] entries = {runner, elite, relay};
        System.out.println("Total balance: " + getTotalBalanceDue(entries));
    }
}