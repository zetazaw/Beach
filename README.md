#Beach
Beach is a simple file writer/ reader from object directly.

##Usage
You need to init in your application or activity to use Beach.


Beach.init(this);

Beach.insert(MyObject.class.getSimpleName(), obj).commit();

List<MyObject> objects = Beach.where(MyObject.class.getSimpleName()).query();
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
