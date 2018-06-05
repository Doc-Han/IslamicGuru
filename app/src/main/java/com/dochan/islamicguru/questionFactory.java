package com.dochan.islamicguru;

public class questionFactory {
    private int index;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answer;

    public static questionFactory[] questions = {
      new questionFactory(1,"How many verses are in the Holy Qur'an","6235","6236","6237","6238",2),
      new questionFactory(2,"How many times is the word Qur'an repeated in the Holy Qur'an","67","68","69","70",4),
      new questionFactory(3,"Which is the best drink mentioned in the Holy Qur'an","Honey","Milk","Water","Juice",2),
      new questionFactory(4,"The best eatable thing mentioned in the Holy Qur'an is","Honey","Milk","Water Melon","Dates(Dabino)",1),
      new questionFactory(5,"Which is the shortest sura of the Holy Qur'an","Falaq","Nass","Ikhlaas","Kausar",4),
      new questionFactory(6,"The most disliked thing by Allah Ta'ala though halal is","Hajj","Divorce","Marriage","Murder",2),
      new questionFactory(7,"Which letter is used the most times in the Holy Qur'an","Wa","Ba'un","Alif","Qaf",3),
      new questionFactory(8,"Which letter is used the least in the Holy Qur'an","Zaa","Maa","Taa","Laa",1),
      new questionFactory(9,"Which is the biggest animal mentioned in the Holy Qur'an","Fish","Whale","Elephant","Anaconda",3),
      new questionFactory(10,"Which is the smallest animal mentioned in the Holy Qur'an","Fly","Mosquito","Spider","Ant",2),
      new questionFactory(11,"How many words are the smallest sura of the Holy Qur'an","41","44","43","42",4),
      new questionFactory(12,"Which sura of the Holy Qur'an is called the mother of Qur'an","Baqara","Fatiha","Ikhlaas","Yaseen",2),
      new questionFactory(13,"How many sura start with Al-Hamdulillah","Four","Six","Five","Seven",3),
      new questionFactory(14,"How many suras name is only one letter","Three","Two","Four","Five",1),
      new questionFactory(15,"How many sura start with 'Inna'","Four","Five","Three","Six",1),
      new questionFactory(16,"How many sura are Makkahi(revealed in Mecca)","87","86","85","86",4),
      new questionFactory(17,"How many suras are Madni(revealed in Medina)","26","28","27","25",2),
      new questionFactory(18,"Which sura is from the name of the tribe of the Holy Prophet","Hashim","Lahab","Quraish","Sab'i",3),
      new questionFactory(19,"Which sura is called the heart of the Holy Qur'an","Yaseen","Ikhlaas","Fatiha","Baqara",1),
      new questionFactory(20,"In which sura is the name of Allah repeated only five times","An'am","Maryam","Mu'meen","Hajj",4),
      new questionFactory(21,"Which sura is the name of one Holy war","Room","Nasr","Ahzab","Fathi",3),
      new questionFactory(22,"Which sura is the name of one metal","Ra'ad","Hadeed","Ahzab","Naml",2),
      new questionFactory(23,"Which sura is called 'Aroos-ul-Qur'an'(the bride of the Qur'an)","Yaseen","Jinn","Rahman","Fatiha",3),
      new questionFactory(24,"Which sura is considered as 1/3 of the holy Qur'an","Falaq","Al-Ikhlas","Nass","Fatiha",2),
	  new questionFactory(25,"Which sura was revealed twice","Iklaas","Yaseen","Fatiha","Ayatul kursiyyu",3),
	  new questionFactory(26,"In which sura is the backbiter condemned","Humaza","Munafiqun","Nuhu","Zalzala",1),
	  new questionFactory(27,"In which sura is the name of Allah repeated in every verse","Iklaas","Mumtahana","Fatiha","Mujadala",4),
	  new questionFactory(28,"In which sura does the letter Fa did not appear","Kaiser","Al-Imaran","Fatiha","Baqara",3),
	  new questionFactory(29,"How many auras start with the word Tabara Kallazii","3","4","1","2",4),
    };

    private questionFactory(int index, String question, String option1, String option2, String option3, String option4, int answer) {
        this.index = index;
        Question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public int getIndex() {
        return index;
    }

    public String getQuestion() {
        return Question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getAnswer() {
        return answer;
    }

    public String toString(){
        return this.Question;
    }
}
