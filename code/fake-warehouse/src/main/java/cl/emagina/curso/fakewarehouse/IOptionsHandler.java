package cl.emagina.curso.fakewarehouse;

interface IOptionsHandler{
	
	//Opcion con sin Override, en donde se declara la variable
	void optionsStart();
	void takeFilePath(String fPath);
	void takeFileOrigin(String fOrigin);
	void takeBdUserPass(String bdUser, String bdPass);
	void takeBdIpPortSchema(String ip, String port, String schema);
	void optionsEnd();
	
	
	//Opcion donde se debe hacer un Override
	/*
	void optionsStart();
	void takeFilePath();
	void takeFileOrigin();
	void takeBdUserPass();
	void takeBdIpPortSchema();
	void optionsEnd();*/
}