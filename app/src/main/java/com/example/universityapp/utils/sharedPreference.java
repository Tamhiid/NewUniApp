package com.example.universityapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreference {

 private static SharedPreferences universityPreference;
 private  static sharedPreference universityInstance;
 static Context UniveristyContext;

 public static String STUDENT_ID = "StudentId";
 public static String CODE = "Code";
 public static String CLASS_ID = "ClassID";
 public static String CLASS_NAME = "ClassName";
 public static String STATUS = "Status";
 public static String SEM_ID = "SemesterID";
 public static String STD_NAME = "StudentName";
 public static String SEM_NAME = "SemesterName";
 public static String PARENT = "ParentName";

 public sharedPreference() {
 }

 public static sharedPreference getInstance(Context context) {
  universityPreference = context.getSharedPreferences("university", context.MODE_PRIVATE);
  return new sharedPreference();
 }

 public void putStudentId(String StudentId) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(STUDENT_ID, StudentId);
  editor.commit();
 }


 public String getStudentId() {
  return universityPreference.getString(STUDENT_ID, "");
 }


 public void putCode(String Code) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(CODE, Code);
  editor.commit();
 }



 public String getCODE() {
  return universityPreference.getString(CODE, "");
 }

 public void putClassID(String ClassID) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(CLASS_ID, ClassID);
  editor.commit();
 }


 public String getClassId() {
  return universityPreference.getString(CODE, "");
 }
 public void putClassName(String ClassName) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(CLASS_NAME, ClassName);
  editor.commit();
 }


 public String getClassName() {
  return universityPreference.getString(CLASS_NAME, "");
 }
 public void putStatus(String Status) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(STATUS, Status);
  editor.commit();
 }


 public String getSTATUS() {
  return universityPreference.getString(STATUS, "");
 }
 public void putSemesterID(String SemesterID) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(SEM_ID, SemesterID);
  editor.commit();
 }


 public String getSemId() {
  return universityPreference.getString(SEM_ID, "");
 }

 public void putStudentName(String StudentName) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(STD_NAME, StudentName);
  editor.commit();
 }


 public String getStdName() {
  return universityPreference.getString(STD_NAME, "");
 }
 public void putSemesterName(String SemesterName) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(SEM_NAME, SemesterName);
  editor.commit();
 }



 public String getSemName() {
  return universityPreference.getString(SEM_NAME, "");
 }

 public void putParentName(String ParentName) {
  SharedPreferences.Editor editor = universityPreference.edit();
  editor.putString(PARENT, ParentName);
  editor.commit();
 }


 public String getPARENT() {
  return universityPreference.getString(PARENT, "");
 }
}
