
public class Course {

    // Attributes
    private String course_Name;
    private String[] students;
    private int N_Of_Students;

    // Constructor
    public Course(String courseName) {
        this.course_Name = courseName;
        this.students = new String[10];
        this.N_Of_Students = 0;
    }

    // Returns the course name
    public String getCourse_Name() {
        return course_Name;
    }

    // Adds a new student
    public void addStudent(String student) {

        // If array is full, create a larger array
        if (N_Of_Students >= students.length) {

            String[] newStudents = new String[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }

            students = newStudents;
        }

        students[N_Of_Students] = student;
        N_Of_Students++;
    }

    // Removes a student
    public void dropStudent(String student) {

        for (int i = 0; i < N_Of_Students; i++) {

            if (students[i].equals(student)) {

                // Move remaining students one position to the left
                for (int j = i; j < N_Of_Students - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[N_Of_Students - 1] = null;
                N_Of_Students--;

                break;
            }
        }
    }

    // Returns the students
    public String[] getStudents() {
        return students;
    }

    // Returns the number of students
    public int getNumberOfStudents() {
        return N_Of_Students;
    }

    // Main method
    public static void main(String[] args) {

        // Create a Course object
        Course course = new Course("Java Programming");

        // Add students
        course.addStudent("Yonis");
        course.addStudent("Hassan");
        course.addStudent("Hussein");

        // Display course name
        System.out.println("Course Name: " + course.getCourse_Name());

        // Display students
        System.out.println("Students:");

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println((i + 1) + ". " + course.getStudents()[i]);
        }

        // Display number of students
        System.out.println("Number of Students: "+ course.getNumberOfStudents());

        // Drop a student
        course.dropStudent("Hassan");

        System.out.println("\nAfter dropping Hassan:");

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println((i + 1) + ". " + course.getStudents()[i]);
        }

        System.out.println("Number of Students: "+ course.getNumberOfStudents());
    }
}
