package com.college.DB;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.college.SomeThingWentE;
import com.college.Dto.CollegeStu;

public interface StuInterface {

	void addStu(CollegeStu m) throws SomeThingWentE, SQLException;

	void updateStu(CollegeStu m)  throws SomeThingWentE, SQLException;

	void deletStu(int id) throws SomeThingWentE, SQLException;

	CollegeStu findId(int id) throws SomeThingWentE, SQLException;

	List<CollegeStu> findSkill(String skill) throws SomeThingWentE, SQLException ;

	List<CollegeStu> findYear(LocalDate yearFrom, LocalDate yearTo)throws SomeThingWentE, SQLException ;

}
