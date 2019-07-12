package day07.test01.demo2;



enum Size {

    /*
    * 文档注释
    * */
    SAMll("S"),MEDIUM("M"),LARGE("L"),EXTAR_LARGE("XL");

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private  String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
