using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class E : MonoBehaviour {
    public GameObject Obj;
    public string NameFunk;
    void Start () {
    }
	void OnTriggerEnter (Collider mane_char)
    {
       // Obj = GetComponent<MeshRenderer>().enabled;
        if (mane_char.tag == "Player")
        {
            Debug.Log("Privet");
            // if (Input.GetKeyDown(KeyCode.E))
            //{
            //if (Obj == true)
            //{
              //  Obj = false;
            }
           
        }
    void OnTriggerStay (Collider mane_char)
    {
        if (mane_char.tag == "Player")
        {
            Debug.Log("Privet");
        }
    }
        //}
    }
