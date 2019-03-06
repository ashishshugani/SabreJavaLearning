package com.assignment.rest.service;

import com.assignment.rest.Student;
import org.springframework.stereotype.Component;


@Component
public class service {

    public Student[] modification(Student[] info){

        Student[] result = new Student[5];
        int k=-1;
        int nameFlag=0;
        int placeFlag=0;

        for(int i = 0 ;i < info.length ; i++){
            for (int j= i+1 ; j< info.length ;j++){
                try{
                    if(!info[i].equals(info[j])){
                        k++;
                        nameFlag=0;
                        placeFlag=0;
                        try{
                            result[k] = new Student();
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Size exceeded");
                        }

                        if(!info[i].getName().matches(info[j].getName())){
                            result[k].setName(info[i].getName() + " " + info[j].getName());
                            nameFlag=1;
                        }

                        if(!info[i].getPlace().matches(info[j].getPlace())){
                            result[k].setPlace(info[i].getPlace() + " " + info[j].getPlace());
                            placeFlag=1;
                        }

                        if(nameFlag==0){
                            result[k].setName(info[i].getName());
                        }

                        if(placeFlag==0){
                            result[k].setPlace(info[i].getPlace());
                        }
                    }

                }
                catch (NullPointerException e){
                    System.out.println("Object is null");
                }

            }
        }

        return result;

    }
}
