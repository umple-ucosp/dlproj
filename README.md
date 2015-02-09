# dlproj

Grab the latest code

```bash
git clone https://github.com/umple-ucsop/dlproj
```

Run the tests

```bash
cd dlproj
(cd ./build/ && ant -Dmyenv=local)
```

To rebuild the java project, you will can just umpleSelf (which converts .ump to .java) and the compile (which compiles the java).  This works nicely if you are working in Eclipse (to run your tests), but rebuilding from the commandline

```bash
(cd ./build && ant -Dmyenv=local umpleSelf compile)
```
