using UnityEngine;
using System.Collections;

namespace PicoGames.VLS2D
{
    public class LoadLevel : MonoBehaviour
    {
        void Update()
        {
            if (Input.GetKeyDown(KeyCode.Space))
                Application.LoadLevel(Application.loadedLevel);
        }
    }
}