# 704-PROJ-1
Designing Advanced Embedded Software Systems - SystemJ Approach

This repository documents the development process of an Automated Bottling System (ABS) written in both Java and systemJ. The (ABS) is an industrial automation tool used to facilitate the formulation and packaging of complex substances. The plant uses a collection of autonomous sub-systems to execute various parts of the manufacturing process in parallel. Each part of the system is affected by a layer of sensor-driven intelligence, removing the need for regular human intervention. 

Full documentation explaining the design decisions and implementation process is fully detailed in the included project report file `report_group_2.pdf`. 


# Running The Code
To run the simulated ABS, follow the following steps:
1. Clone the reposity or download the source code on a windows 10/11 machine which has the Eclipse IDE installed. 
2. Open Eclipse IDE and click `file > import > General > Existing Projects into Workspace > browse`, then navigate to `~/704-PROJ-1/src/abs` then click `finish`. 
3. Within the package explorer that appears on the left side of the screen, right click `BuildAll.launch` then click `Run As` and select `1 Build All`. Ensure that the console view displays `<terminated>` before progressing.
4. Right click the main project file at the top of the explorer, and click `Refresh`.
5. Right click `LaunchABS.launch` then click `Run As` and select `1 Launch ABS`.
6. Two windows will appear, the POS and the Visualizer. [TODO] ADD MORE INFO
7. 

## Code structure and folders
- bin: Contains the compiled systemJ files
- lib: Contains essential libraries required to run the project
- res: Contains images used in the POS and Visualizer
- src: contains 3 sub folders
  - org/compsys704: Contains the Java fliles 
  - run: Contains simple Java files that start files in the above folder
  - util: Contains utility Java files 
- sysj: Contains the systemJ files for the MPR, machine controllers, and plant models

The Java code for the POS and Visualization are located within `src/org/compsys704`


