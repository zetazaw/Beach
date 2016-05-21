#Beach
Beach is a simple file writer/ reader from object directly.

##Usage
You need to init in your application or activity to use Beach.

`
Beach.init(this);
`

Reference the object model class.

`
Beach beach = Beach.create(YourObject.class);
`

Insert the data.

`
beach.insert(new YourObject("yourdata"));
`

Commit it to file.

`
beach.commit();
`

__you can check your commit is success or not because the commit() method return boolean__


You can get your data easily if you wrote with Beach!

`
YourObject obj = Beach.create(YourObject.class).query();
`


__Please let me know if any issues you find from Beach.__


### Gradle


allprojects {

    repositories {
    
        jcenter()
        
        maven { url "https://jitpack.io" }
        
    }
    
}

dependencies {

    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    ...
    
    compile 'com.github.zetazaw:Beach:-SNAPSHOT'

}
