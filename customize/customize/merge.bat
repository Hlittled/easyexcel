rem 合并多个jar包为一个

rmdir /S /Q merge
mkdir temp
mkdir merge
cd temp

jar -xvf ..\customize-asm-4.2.jar
jar -xvf ..\customize-cglib-3.1.jar
jar -xvf ..\customize-commons-codec-1.10.jar
jar -xvf ..\customize-commons-collections4-4.1.jar
jar -xvf ..\customize-curvesapi-1.04.jar
jar -xvf ..\customize-ehcache-3.4.0.jar
jar -xvf ..\customize-poi-3.17.jar
jar -xvf ..\customize-poi-ooxml-3.17.jar
jar -xvf ..\customize-poi-ooxml-schemas-3.17.jar
jar -xvf ..\customize-slf4j-api-1.7.26.jar
jar -xvf ..\xmlbeans-3.1.0.jar
jar -xvf ..\customize-easyexcel-2.2.11.jar

jar -cvfM all-customize-easyexcel-2.2.11.jar .

move all-customize-easyexcel-2.2.11.jar ..\merge\

cd ..

rmdir /S /Q temp