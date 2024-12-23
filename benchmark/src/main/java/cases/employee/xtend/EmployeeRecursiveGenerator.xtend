
class EmployeeRecursiveGenerator {

	def String generate(Employee employee) {
		'''
		Employee(«employee.id», "«employee.name»", "«employee.position»", [
        «FOR subordinate : employee.subordinates»«generate(subordinate)
        	»«IF !subordinate.equals(employee.subordinates.last)»,«ENDIF»
        «ENDFOR»])
		'''
	}
}