package testJava3D;
import java.io.FileNotFoundException;

import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Light;
import javax.media.j3d.Material;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JApplet;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class SpherePhotos extends JApplet {

    public void init() {
    	Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
    	this.add("Center", canvas3D);
    	    	
    	BranchGroup objRoot=new BranchGroup();
    	ObjectFile objFile=new ObjectFile(); 
    	Scene scene=null;
    	try {
    		scene=objFile.load("testJava3D/colonne.obj");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParsingErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	    	
		Appearance app=new Appearance();
       	/*TextureLoader loader=new TextureLoader(getImage(getCodeBase(),"earth.jpg"),this);
       	Texture texture=loader.getTexture();
    	app.setTexture(texture);
    	TextureAttributes textureAt=new TextureAttributes();
    	textureAt.setTextureMode(TextureAttributes.MODULATE);
    	app.setTextureAttributes (textureAt);    
    	app.setMaterial (new Material (new Color3f (), 
                                                     new Color3f (0.08f, 0.08f, 0.08f), 
                                                     new Color3f (1, 1, 1), 
                                                     new Color3f (), 0));
        Transform3D rotate = new Transform3D();
    	rotate.rotZ(-Math.PI/7.0d);
    	TransformGroup objSpin=new TransformGroup();
    	objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	Alpha rotationAlpha=new Alpha(-1,30000);
    	RotationInterpolator rotator=new RotationInterpolator(rotationAlpha,objSpin);
    	BoundingSphere bounds=new BoundingSphere();
    	rotator.setSchedulingBounds(bounds);
    	rotator.setTransformAxis(rotate);
    	objSpin.addChild(rotator);*/
    	Sphere sphere=new Sphere(0.9f,Sphere.GENERATE_NORMALS|Sphere.GENERATE_TEXTURE_COORDS,50,app);
    	//objSpin.addChild(sphere);
    	//objRoot.addChild(objSpin);  
    	objRoot.addChild(sphere);
    	
    	Light light=new DirectionalLight(true,new Color3f(1f,1f,1f),new Vector3f (1, 0, -1));
    	light.setInfluencingBounds (new BoundingSphere (new Point3d (), 150.0));
    	objRoot.addChild(light);
    
    	
    	/*TextureLoader loader2=new TextureLoader(getImage(getCodeBase(),"fond.jpg"),this);
    	ImageComponent2D fond=loader2.getImage();
    	Background background=new Background(fond);
    	background.setApplicationBounds(new BoundingBox());
    	objRoot.addChild(background);*/
    	
        objRoot.compile();
    	SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
    	simpleU.addBranchGraph(objRoot);
    	simpleU.getViewingPlatform().setNominalViewingTransform();
    }
}
