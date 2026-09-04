package main.java.oop.class_problems;
class HostelRoom 
{
    int roomNo;
    int beds;
    int occupied;
    HostelRoom(int roomNo, int beds) 
    {
        this.roomNo = roomNo;
        this.beds = beds;
        occupied = 0;
    }
    void allot(String name) 
    {
        if (occupied < beds) 
        {
            occupied++;
            System.out.println(name + " allotted to room " + roomNo);
        }
    }
    static HostelRoom findAvailableRoom(HostelRoom[] rooms) 
    {
        for (HostelRoom room : rooms) 
        {
            if (room.occupied < room.beds) 
            {
                return room;
            }
        }
        return null;
    }
    static void safeAllot(HostelRoom[] rooms, String studentName) 
    {
        HostelRoom room = findAvailableRoom(rooms);
        if (room != null) 
        {
            room.allot(studentName);
        } 
        else 
        {
            System.out.println("No rooms available for " + studentName);
        }
    }
    public static void main(String[] args) 
    {
        HostelRoom[] rooms = { new HostelRoom(101, 2), new HostelRoom(102, 2)};
        safeAllot(rooms, "Ravi");
        rooms[0].occupied = 2;
        rooms[1].occupied = 2;
        safeAllot(rooms, "Meera");
    }
}