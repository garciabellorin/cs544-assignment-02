1. Create a **Person** with a *name* and *DOB*.
2. Create a **Company** with a *name* and *Address*.
   - The address is an ***@Embeddable*** Entity.
4. Create an **CarManufacturer** that is a **Company**, it has a property *numberOfEmployees*, *yearEstablished*.
5. Create an **InsuranceCompany** that is a **Company**, it has an integer *rating*.
6. Each **Car** has:
   * One **CarManufacturer** that creates it.
   * Zero or one **InsuranceCompany** that insures it. 
   * One or two *owners*. A Car has 
   * Zero or more *drivers*.

* You may assume all the relationships above are bi-directional.
* Create at least:
   * Three carrs
   * Five People
   * Two insurance companies
   * Three CarManufacturers (
   
   **Notes:** 
   * A car manufacturer can manufacture more than one car and the same for insurance companies).
   * Anything not stated in the requirement above you have the freedom to implement any way you wish.
	
