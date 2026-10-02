package main.java.abstract_interf.assignment_problems;
interface Exportable 
{
    void export();
    void export(String path);
}
class PdfReport implements Exportable 
{
    private static int exportCount = 0;
    @Override
    public void export() 
    {
        exportCount++;
        System.out.println("Exporting PDF report");
    }
    @Override
    public void export(String path) 
    {
        exportCount++;
        System.out.println("Exporting PDF report to " + path);
    }
    public static int getExportCount() 
    {
        return exportCount;
    }
}
class CsvReport implements Exportable 
{
    @Override
    public void export() 
    {
        System.out.println("Exporting CSV report");
    }
    @Override
    public void export(String path) 
    {
        System.out.println("Exporting CSV report to " + path);
    }
}
public class DataExport 
{
    public static void main(String[] args) 
    {
        Exportable pdf = new PdfReport();
        Exportable csv = new CsvReport();
        pdf.export();
        pdf.export("reports/data.pdf");
        csv.export();
        csv.export("reports/data.csv");
        System.out.println("Total PDF exports: " + PdfReport.getExportCount());
    }
}