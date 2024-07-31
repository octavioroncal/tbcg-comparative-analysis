public class Form{
 private String className;
 
 private Field fields;
 
 
 public Form()
 {
 }
 public String getClassName(){
  return this.className;
 }
 
 public Field getFields(){
  return this.fields;
 }
 public void setClassName(String className){
  this.className=className;
 }
 
 public void setFields(Field fields){
  this.fields=fields;
 }
 
}
