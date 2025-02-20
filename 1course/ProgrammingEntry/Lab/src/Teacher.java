
public class Teacher {
    TeacherList chair;
    String name;
    String chairName;
    String status;

    String facultyName;

    public Teacher(TeacherList chair){
        this.name = spellingCheck(DataInput.getStr("Enter teacher's name: "));
        this.status = DataInput.getStr("Status: ");
        this.chairName = chair.chairName;
        this.facultyName = chair.facultyName;
        this.chair = chair;
    }

    public Teacher(TeacherList chair, String status, String name) {
        this.name = name;
        this.status = status;
        this.chairName = chair.chairName;
        this.facultyName = chair.facultyName;
        this.chair = chair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void changeChair(TeacherList chairNew) {
        chair.removeTeacher(this);
        chairNew.addTeacher(this);
        this.chairName = chairNew.chairName;
        this.facultyName = chairNew.facultyName;
    }
    public String spellingCheck(String name){
        boolean state = true;
        String str = "";
        for (int i = 0; i < name.length(); i++) {
            if(!state) {
                if (name.charAt(i) == 32)
                    state = true;
                str += name.charAt(i);
            }
            if(state&&name.charAt(i) != 32){
                if(name.charAt(i)>=97&&name.charAt(i)<=122)
                    str += (char) (name.charAt(i) - 32);
                else
                    str += name.charAt(i);
                state = false;
            }
        }
        return str;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Teacher(name='" + name + "', chair='" + chairName + "', status='" + status + "')\n";
    }
}