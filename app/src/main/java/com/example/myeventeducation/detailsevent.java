package com.example.myeventeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class detailsevent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsevent);
    }
    <ImageView
    android:id="@+id/imageView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:contentDescription="@string/todo"
    android:src="@drawable/seminarlandscape1"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="0dp"
    tools:layout_editor_absoluteY="-264dp" />

    <Button
    android:id="@+id/button2"
    android:layout_width="138dp"
    android:layout_height="55dp"
    android:background="#FFC107"
    android:text="@string/not_available"
    android:textColorHighlight="#FFFFFF"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="332dp"
    tools:layout_editor_absoluteY="426dp" />
    <Button
    android:id="@+id/button3"
    android:layout_width="105dp"
    android:layout_height="52dp"
    android:background="#FFC107"
    android:text="@string/rp_100_000"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="29dp"
    tools:layout_editor_absoluteY="426dp" />

    <ImageButton
    android:id="@+id/imageButton11"
    android:layout_width="61dp"
    android:layout_height="61dp"
    android:tint="#00000000"
    android:src="@drawable/ic_kembali"
    tools:layout_editor_absoluteX="16dp"
    tools:layout_editor_absoluteY="16dp"
    tools:ignore="MissingConstraints"
    android:contentDescription="@string/todo" />

    <ImageButton
    android:id="@+id/imageButton12"
    android:layout_width="83dp"
    android:layout_height="64dp"
    android:contentDescription="@string/todo"
    android:src="@drawable/ic_search"
    android:tint="#00000000"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="210dp"
    tools:layout_editor_absoluteY="778dp" />

    <TextView
    android:id="@+id/textView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/browse"
    android:textSize="22sp"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="214dp"
    tools:layout_editor_absoluteY="840dp" />

    <TextView
    android:id="@+id/textView2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/settings"
    android:textSize="20sp"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="386dp"
    tools:layout_editor_absoluteY="842dp" />

    <TextView
    android:id="@+id/textView3"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/discover"
    android:textSize="22sp"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="46dp"
    tools:layout_editor_absoluteY="840dp" />

    <ImageButton
    android:id="@+id/imageButton13"
    android:layout_width="80dp"
    android:layout_height="67dp"
    android:contentDescription="@string/todo"
    android:src="@drawable/ic_discover"
    android:tint="#00000000"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="46dp"
    tools:layout_editor_absoluteY="772dp" />

    <ImageButton
    android:id="@+id/imageButton9"
    android:layout_width="79dp"
    android:layout_height="68dp"
    android:contentDescription="@string/todo"
    android:src="@drawable/ic_settings"
    android:tint="#00000000"
    tools:ignore="MissingConstraints"
    tools:layout_editor_absoluteX="382dp"
    tools:layout_editor_absoluteY="772dp" />

    <ImageView
    android:id="@+id/imageView4"
    android:layout_width="489dp"
    android:layout_height="214dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.538"
    app:layout_constraintStart_toStartOf="parent"
    app:srcCompat="@drawable/persegipanjang"
    tools:layout_editor_absoluteY="204dp"
    tools:ignore="MissingConstraints"
    android:contentDescription="@string/todo" />

    <TextView
    android:id="@+id/textView4"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/seminar_iso_indonesia"
    android:textSize="26sp"
    android:textStyle="bold"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    tools:layout_editor_absoluteY="225dp"
    tools:ignore="MissingConstraints" />

    <ImageView
    android:id="@+id/imageView8"
    android:layout_width="78dp"
    android:layout_height="79dp"
    app:srcCompat="@drawable/persegi"
    tools:layout_editor_absoluteX="50dp"
    tools:layout_editor_absoluteY="311dp"
    tools:ignore="MissingConstraints"
    android:contentDescription="@string/todo" />

    <TextView
    android:id="@+id/textView7"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/_19"
    android:textColor="#FFC107"
    android:textSize="34sp"
    android:textStyle="bold"
    tools:layout_editor_absoluteX="70dp"
    tools:layout_editor_absoluteY="344dp"
    tools:ignore="MissingConstraints" />

    <TextView
    android:id="@+id/textView5"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/by_proxsis_consulting_group"
    android:textSize="20sp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.502"
    app:layout_constraintStart_toStartOf="parent"
    tools:layout_editor_absoluteY="260dp"
    tools:ignore="MissingConstraints" />

    <TextView
    android:id="@+id/textView6"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/nov"
    android:textSize="28sp"
    android:textStyle="bold"
    tools:layout_editor_absoluteX="60dp"
    tools:layout_editor_absoluteY="311dp"
    tools:ignore="MissingConstraints" />

    <TextView
    android:id="@+id/textView8"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/proxsis_consulting"
    android:textColor="#FFC107"
    android:textSize="20sp"
    android:textStyle="bold"
    tools:layout_editor_absoluteX="174dp"
    tools:layout_editor_absoluteY="300dp"
    tools:ignore="MissingConstraints" />

    <TextView
    android:id="@+id/textView9"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/_09_30_wib"
    android:textSize="20sp"
    tools:layout_editor_absoluteX="197dp"
    tools:layout_editor_absoluteY="339dp"
    tools:ignore="MissingConstraints" />

    <ImageView
    android:id="@+id/imageView12"
    android:layout_width="43dp"
    android:layout_height="51dp"
    app:srcCompat="@drawable/garistegakhitam"
    tools:layout_editor_absoluteX="289dp"
    tools:layout_editor_absoluteY="330dp"
    tools:ignore="MissingConstraints"
    android:contentDescription="@string/todo" />

    <TextView
    android:id="@+id/textView10"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/ticket_left_2"
    android:textSize="20sp"
    tools:layout_editor_absoluteX="322dp"
    tools:layout_editor_absoluteY="339dp"
    tools:ignore="MissingConstraints" />

    <ImageView
    android:id="@+id/imageView13"
    android:layout_width="43dp"
    android:layout_height="45dp"
    android:src="@drawable/ic_waktu"
    tools:layout_editor_absoluteX="145dp"
    tools:layout_editor_absoluteY="330dp"
    tools:ignore="MissingConstraints" />

    <ImageView
    android:id="@+id/imageView14"
    android:layout_width="49dp"
    android:layout_height="46dp"
    android:src="@drawable/ic_tandaseru"
    tools:layout_editor_absoluteX="29dp"
    tools:layout_editor_absoluteY="500dp"
    tools:ignore="MissingConstraints" />

    <TextView
    android:id="@+id/textView12"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/dekripsi_acara"
    android:textSize="22sp"
    tools:layout_editor_absoluteX="85dp"
    tools:layout_editor_absoluteY="508dp"
    tools:ignore="MissingConstraints" />

    <ImageView
    android:id="@+id/imageView15"
    android:layout_width="327dp"
    android:layout_height="188dp"
    app:srcCompat="@drawable/forumiso"
    tools:layout_editor_absoluteX="16dp"
    tools:layout_editor_absoluteY="565dp"
    tools:ignore="MissingConstraints" />
}
