# Beach
Android Object File Creater

Beach is a simple file writer/ reader from object directly. 

1. You need to init in your application or activity to use Beach. 

Beach.init(this);

2. Reference the object model class.

Beach beach = Beach.create(YourObject.class);

3. Insert the data.

beach.insert(new YourObject("yourdata"));

4. Commit it to file.

beach.commit();

# you can check your commit is success or not because the commit() method return boolean

5. You can get your data easily if you wrote!

YourObject obj = Beach.create(YourObject.class).query();

Please let me know if any issues you find from Beach. 
