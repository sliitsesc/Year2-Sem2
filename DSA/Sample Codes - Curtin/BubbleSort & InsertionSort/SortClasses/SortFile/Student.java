class Student
{
    private Integer studentID;
    private String studentName;

    public Student(Integer pStudentID, String pStudentName) //Construtor with Parameters
    {
        studentID = pStudentID;
        studentName = pStudentName;
    }

    public Student() //Default Constructor
    {
        studentID = -1;
        studentName = "Placeholder Name";
    }

    public Student(Student pStudent) //Copy Constructor
    {
        studentID = pStudent.getStudentID();
        studentName = pStudent.getStudentName();
    }

    public Integer getStudentID() //retrieve the StudentID component of the Object Student
    {
        return studentID;
    }

    public String getStudentName() //retrieve the StudentName component of the Object Student
    {
        return studentName;
    }

    public void setStudentID(Integer pStudentID) //Set the StudentID component of the Object Student
    {
        studentID = pStudentID;
    }

    public void setStudentName(String pStudentName) //Set the StudentName component of the Object Student
    {
        studentName = pStudentName;
    }

    public String toString() //Convert the Object Student to String Format
    {
        String studentString = "The name of the student is " + studentName + " bearing the Student ID " + studentID;
        return studentString;
    }

    public boolean equals(Object pObject) //Compare two objects to see if its is equal to an Object Student
    {
        boolean isEqual = false;
        Student pStudent = null;

        if(pObject instanceof Student)
        {
            pStudent = (Student)pObject;
            if(studentID == pStudent.getStudentID())
            {
                if(studentName.equals(pStudent.getStudentName()))
                {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    }
}