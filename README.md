This program initializes a PWE (Programmable Wireless Enviromenent) and extracts a Graph, whoose Nodes 
are the system elements (Transmitter, Receiver and Software Defined Metasurfaces (Tiles). These elements are positioned
inside a cuboid room filled with Obstacles. Obstacles are represented by spheres of randomized positions and radiuses. The positions
of the different elements of the system are also randomized.

Input parameters for the creation of a single Graph Object:

1. Room Object : 
    with input parameters -->  x,y,z dimensions , number of Users, number Of tiles , path loss exponent alpha 
2. TileConfig Object :
    with input parameters -->element spacing , element gain, number of elements, wavelength (encapsulated in the TileConfig Object)
3. TxConfig Object:
    with input parameters --> number of Lobes , gain per lobe , transmit power, wavelength (encapsulated in the TxConfig Object)

Firstly these 3 objects are initialized (given their input Parameters)
