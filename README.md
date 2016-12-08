#Beach
Beach is a simple file writer/ reader from object directly.

##Usage
You need to init in your application or activity to use Beach.


Beach.init(this);

see the exmple project

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
