package com.springboot.api.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email=Email;
    }

    public String getOrganization(){
        return organization;
    }

    public void setOrganization(String organization){
        this.organization=organization;
    }

    @Override
    public String toString(){
        return "MemberDto{"+
                "Name='"+name+'\''+
                ", email='"+email+'\''+
                ", organization='"+organization+'\''+
                '}';
    }
}
