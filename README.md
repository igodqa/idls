##How to run tests

Email / password should be passed as parameters from command
line.

Chrome is set as default browser. So, if no browser is specified, the test will run in Chrome browser.

To run test in Chrome execute the following command in commandline:

```bash
mvn -Dbrowser=chrome -Demail=*** -Dpass=*** test
```
or
```bash
mvn -Demail=*** -Dpass=*** test
```

To run test in Firefox execute the following command in commandline:
```bash
mvn -Dbrowser=firefox -Demail=*** -Dpass=*** test
```
