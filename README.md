# 704-PROJ-1 (Group 2) 
Designing Advanced Embedded Software Systems - SystemJ Approach

This repository documents the development process of an Automated Bottling System (ABS) written in both Java and systemJ. The ABS is an industrial automation tool used to facilitate the formulation and packaging of complex substances. The plant uses a collection of autonomous sub-systems to execute various parts of the manufacturing process in parallel. Each part of the system is affected by a layer of sensor-driven intelligence, removing the need for regular human intervention. 

Full documentation explaining the design decisions and implementation process is fully detailed in the included project report file.


# Running The Code
To run the simulated ABS, perform the following steps:
1. Clone the repository or download the source code on a Windows 10/11 machine that has the Eclipse IDE installed. 
2. Open Eclipse IDE and click `file > import > General > Existing Projects into Workspace > browse`, then navigate to `~/704-PROJ-1/src/abs` then click `finish`. 
3. Within the package explorer that appears on the left side of the screen, right-click `BuildAll.launch` then click `Run As` and select `1 Build All`. Ensure that the console view displays `<terminated>` before progressing.
4. Right-click the main project file at the top of the explorer, and click `Refresh`.
5. Right-click `LaunchABS.launch` then click `Run As` and select `1 Launch ABS`.
6. Two windows will appear, the POS and the Visualizer. Within the POS, specify a bottle quantity, and volume of the four liquids.
7. Click `Order`, then `Make Order`
8. On the ABS Live visualizer, clicking the `Enable` button will step through the bottling process.
9. Additionally, clicking the `Break Lid Loader` or `Break Turn Table` checkboxes will simulate faults in the respective machines, enabling fault tolerance mechanisms. The visualizer will show the Baxter robot manually adding lids and turning the rotary turntable. 

The operation of all machines can be monitored through their respective console windows.

## Code structure and folders
- bin: Contains the compiled systemJ files
- lib: Contains essential libraries required to run the project
- res: Contains images used in the POS and Visualizer
- src: contains 3 subfolders
  - org/compsys704: Contains the Java files 
  - run: Contains simple Java files that start files in the above folder
  - util: Contains utility Java files 
- sysj: Contains the systemJ files for the MPR, machine controllers, and plant models


