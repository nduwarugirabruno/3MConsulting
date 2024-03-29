# 3M CONSULTING
### WE TAKE THE NEXT STEP TOGETHER

[![3M CONSULTING](.assets/images/logo-removebg-001.png)](https://github.com/nduwarugirabruno/3MConsulting)

3M Consulting is a platform for bringing together customers and contractors.

It can be previewed on my GitHub repository here: https://github.com/nduwarugirabruno/3MConsulting

## Getting Started

To start building, clone this repository:

```bash
git clone https://github.com/nduwarugirabruno/3MConsulting.git
```

Once cloned, run the following to install dependencies and run the app:

```bash
cd /path/to/the/cloned/repository/folder
# open with your code editor for exemple IntelliJ IDEA or Visual Studio Code
idea ./
```

## Structure

We have 3 sub folders and the readme file:

```bash
links@links:~/IdeaProjects/3MConsulting$ ls
      3MC-Chat  
      3MC-Notification  
      3MC-Offre
      3MC-Transaction  
      3MC-User
      EurekaServer
      README.md
      script.sh
```

- The first folder [3MC-Chat](3MC-Chat) is the Chat Service developed in Spring Boot x Spring Cloud framework
- The second folder [3MC-Notification](3MC-Notification) is the Notification Service developed in Spring Boot x Spring Cloud framework
- The third folder [3MC-Offre](3MC-Offre) is the Offer Service developed in Spring Boot x Spring Cloud framework
- The fourth folder [3MC-Transaction](3MC-Transaction) is the Transaction Service developed in Spring Boot x Spring Cloud framework
- The fifth folder [3MC-User](3MC-User) is the User Service developed in Spring Boot x Spring Cloud framework
- The sixth folder [EurekaServer](EurekaServer) is the Eureka Server developed in Spring Boot x Spring Cloud framework
- The seventh file is this [README.md](README.md) file which describe the project.
- The last file [script.sh](script.sh) is the script which launch the entire project.

## Execution

To execute the project, run:

```bash
links@links:~/IdeaProjects/3MConsulting$ ls
      3MC-Notification 3MC-Offre 3MC-Transaction  3MC-User EurekaServer README.md script.sh 
links@links:~/IdeaProjects/3MConsulting$ chmod +x script.sh       // This command is used to make the script executable 
links@links:~/IdeaProjects/3MConsulting$ ./script.sh              // This command is used to execute the script
```

## Production

To build for production, run:

```bash
```

## Unit Tests

To run the unit tests once, run:

```bash
```
- /suggested
- /suggested