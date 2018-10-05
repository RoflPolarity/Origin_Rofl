using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class E : MonoBehaviour
{
    private MeshRenderer Render;
    void Start()
    {
        Render = GetComponentInChildren<MeshRenderer>();
    }
    void Update()
    { }

        void OnTriggerStay2D(Collider2D mane_char)
        {
            if (mane_char.tag == "char")
            {
                if (Input.GetKeyDown(KeyCode.E))
                {
                    Render.enabled = !Render.enabled;
                }
            }
        }
  }
