package com.example.fismo.ui.training;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.R;
import com.example.fismo.databinding.FragmentTrainingBinding;
import com.example.fismo.ui.Exercise.ExerciseFragment;
import com.example.fismo.ui.achievements.AchievementsFragment;
import com.example.fismo.ui.training.TrainingViewModel;

public class TrainingFragment extends Fragment {

    private TrainingViewModel trainingViewModel;
    private FragmentTrainingBinding binding;
    Button crunches;
    Button plank;
    Button Biceps;
    Button Cobra;
    Button CKC;
    Button Calf;
    Button Neck;
    Button superman;
    Button sumo;
    Button sidePl;
    Button HighPl;
    Button pushup;
    Button pushleg;
    Button Prone;
    Button Twist;
    Button climbers;
    Button supine;
    Button inchWorms;

    String desc = "Step 1: Lie on your back on a mat with your knees bent, feet flat on the floor and heels fully placed on the ground.\n" +
            "Step 2: Place your hands behind your head, squeezing your shoulder blades together and pulling your elbows back without arching your low back. Align your head with your spine, but allow it to move into slight flexion during the upward phase of the exercise.\n" +
            "Step 3: Upward phase: Exhale, contract your abdominal and core muscles and flex your chin slightly towards your chest while slowly curling your torso towards your thighs. Your feet, tailbone and lower back should remain in contact with the mat at all times. Continue curling up until your upper back is lifted off the mat. \n" +
            "Step 4: Downward phase: gently inhale and slowly uncurl your torso back towards the mat in a controlled fashion keeping your feet, tailbone and low back in contact with the mat.\n";

    String desc2 = "Step 1: Starting position: lie on your right side on an exercise mat with your left leg lying directly over your right leg and bend your knees to a comfortable position. Raise your upper body to support yourself on your right arm, your right elbow should bend to 90 degrees and be positioned directly under your shoulder. Align your head with your spine and keep your hips and lower knee in contact with the exercise mat.\n" +
            "\n" +
            "Step 2: Upward phase: exhale, gently contact your core muscles to stiffen your spine and lift your hips off the mat, but keeping contact with your knee, and head aligned with your spine.\n" +
            "Step 3: Lowering phase: inhale and gently return yourself to your starting position.\n";
    String desc3 = "Step 1: Starting position: assume a seated bent-knee position, feet placed flat on the floor and arms outstreched behind you with your palms flat on the floor and fingers pointed away from your body. \n" +
            "Step 2: Gently exhale and slowly slide your butt forwards towards your feet without moving your hands. This should create a stretch through your biceps with some stretching in the front shoulder region. Push yourself forward to the point of tension in the stretch, but never bounce or push to a point of pain. Hold this position for 15 – 30 seconds then relax by returning to your starting position and repeat 2-4 times.\n";
    String desc4 = "Step 1: Starting position: Lie on your stomach on an exercise mat or floor with your hands by your sides, positioned directly under your shoulders and hands facing forward. Extend your legs and toes point away from body.\n" +
            "Step 2: Upward phase: gently exhale and press your hips into the mat and pull your chest away from the ground while keeping your hips stable. Hold this position for 15 – 30 seconds.\n" +
            "Step 3: Downward phase: gently relax and lower your upper body to rest back upon the mat / floor.\n";
    String desc5 = "Step 1: Starting position: kneel on an exercise mat or floor positioning your knees and feet hip-width apart, with your toes pointing towards your body. Slowly lean forward to place your hands on the mat, positioning them directly under your shoulders at shoulder-width with your fingers facing forward. Reposition your hands and knees as necessary so that your knees are directly under your hips and hands are directly under your shoulders. Stiffen your abdominal muscles to position your spine in a neutral position, avoid any excessive sagging or arching.\n" +
            "Step 2: Slide your right hand forward to a staggered stance position, moving it 15 to 30 centimeters forward of the shoulder. Internally rotate both arms turning your finger tips to the center. Hold this position for 5 – 10 seconds for a total of 2 – 4 repetitions. Repeat switching hand positions.\n";
    String desc6 = "Step 1: Starting position: stand 15 – 30 centimeters away from a wall with your feet hip-width apart and facing forward. Extend your arms to place your palms on the wall, level with your chest or shoulders.\n" +
            "Step 2: Upward phase: exhale and slowly lift your heels off the floor keeping your knees extended and without rotating your feet. Use your hands on the wall to support your body. Hold raised position briefly.\n" +
            "Step 3: Downward phase: inhale and slowly lower your heels back towards the floor.\n";
    String desc7 = "Step 1: Starting position: stand with your feet hip-width apart, toes pointing forward or turned slightly outwards, with arms by your sides. Stiffen your abdominal muscles to stabilize your spine, then depress and pull your shoulders down and back without arching your low back.\n" +
            "Step 2: Slowly draw your right ear towards your right shoulder stopping when you feel the stretch. Be sure to maintain body alignment keeping your shoulders down and back. Hold the stretch for 5 – 10 seconds. Slowly return to starting position. Repeat on life side. Perform a total of 2 – 4 repetitions both sides.\n";
    String desc8 = "Step 1: Starting position: lie on your stomach on a mat with your legs extended, toes pointing away from your shins, arms extended overhead with palms facing each other. Relax your head to align it with your spine.\n" +
            "Step 2: Upward phase: exhale, contact your abdominal and core muscles to stabilize your spine and slowly raise both legs off the floor while simultaneously raising both arms off the floor. Keep both legs and arms extended and avoiding any rotation in each. Maintain your head and torso position, avoiding any arching in your back or raising of your head. Hold this position briefly.\n" +
            "Step 3: Downward phase: gently inhale and lower your legs and arms back towards your starting position without any movement in your low back or hips.\n";
    String desc9 = "Step 1: Starting position: stand with your feet wider than hip-width with your arms by your sides. Pull your shoulders down and back without arching your low back, and engage your abdominal and core muscles to stiffen your spine.\n" +
            "Step 2: Movement: drop into a wide-stance squat position, lowering your body to a comfortable depth or until your thighs lie parallel to the floor and your body weight rests on your heels. Feel free to position your arms where they assist you in maintaining balance.\n" +
            "Step 3: Push upwards into triple extension (extending the ankle, knee and hip joints) simultaneously rotating your body forward and pivoting 180-degrees your inside foot. Lift your outer leg off the ground and rotate it around to place it 60 – 90 centimeters away from your pivoting foot.\n" +
            "Step 4: Upon placing your outer leg, firmly on the floow, drop once again into a wide-stance squat position, lowering your body to a comfortable depth or untill your thighs lie parallel to the floow and your body weight rests on your heels.\n" +
            "Step 5: Repeat this movement in one direction or stopping to turn back towards your starting position.\n";
    String desc10 = "Step 1: Starting Position: Lie on your right side on an exercise mat with extended legs, placing your left leg directly over your right leg and and stacking your feet one on top of the other. Place your right elbow directly under your shoulder, align your head with your spine and keep your hips and right knee in contact with the exercise mat.\n" +
            "Step 2: Upward Phase: Exhale, gently contract your abdominal / core muscles to stiffen your spine and lift your hips and knees off the mat, keeping contact with the side of your right foot and keep head aligned with your spine. Keep your right elbow positioned directly under your shoulder.\n" +
            "Step 3: Lowering Phase: Inhale and gently return yourself to your starting position. Alternate sides and repeat.\n";
    String desc11 ="Step 1: Start in a push-up position with hands under the shoulders and the legs straightened directly behind the body about hip-width apart. Squeeze the thighs and glutes while straightening the right arm and pressing it into the floor. At the same time, lift the left hand up and twist the hips and shoulders to raise the left arm up towards the ceiling. Bring the left arm down, press the left hand into the floor, and twist the hips and shoulders to alternate sides, lifting the right hand into the air. Repeat for the desired number of repetitions.";
    String desc12 = "Step 1: Starting Position: Kneel on an exercise mat or floor and bring your feet together behind you.\n" +
            "Step 2: Slowly bend forward to place your palms flat on the mat, positioning your hands shoulder-width apart with your fingers facing forward or turned slightly inward. Slowly shift your weight forward until your shoulders are positioned directly over your hands. Reposition your hands as needed to allow full extension of your body without any bend at the hips or knees. Stiffen your torso by contracting your core/abdominal muscles, your glute and quadriceps muscles and align your head with your spine. Place your feet together with toes pointed towards your shins.\n" +
            "Step 3: Downward Phase: Slowly lower your body towards the floor while maintaining a rigid torso and head aligned with your spine. Do not allow your low back to sag or your hips to hike upwards during this downward phase. Continue to lower yourself until your chest or chin touch the mat/floor. Allow your elbows to flare outwards during the lowering phase.\n" +
            "Step 4: Upward Phase: Press upwards through your arms while maintaining a rigid torso and head aligned with your spine. For extra strength think about pushing the floor away from you. Do not allow your low back to sag or your hips to hike upwards. Continue pressing until the arms are fully extended at the elbows.\n";
    String desc13 = "Step 1: Starting Position: Kneel on an exercise mat or floor and bring your feet together behind you.\n" +
            "Step 2: Slowly bend forward to place your palms flat on the mat, positioning your hands shoulder-width apart with your fingers facing forward. Slowly shift your weight forward until your shoulders are positioned directly over your hands. Reposition your hands as needed to allow full extension of your body without any bend at the hips or knees. Stiffen your torso by contracting your core and abdominal muscles and align your head with your spine. Place your feet together with toes pointed towards your shins.\n" +
            "Step 3: Downward Phase: Slowly lower your body towards the floor while maintaining a rigid torso and head aligned with your spine. Do not allow your low back to sag or your hips to hike upwards during this downward phase, contract your butt and thigh muscles to create stability for your core. Continue to lower yourself until your chest or chin touch the mat or floor. Your elbows should remain close to the sides of your body or be allowed to flare outwards slightly.\n";
    String desc14 = "Step 1: Starting Position: Lie on your stomach on a mat, with your arms and legs fully extended.  Point your toes away from your body and fully extend your elbows and fingers, positioning your palms facing inwards.  Stiffen your abdominal muscles to stabilize your spine, depress and pull shoulders back and down and attempt to hold these positions throughout the exercise. Align your head with your upper spine.\n" +
            "Step 2: “I” Formation: Gently exhale and slowly lift your arms off the floor (maintain a formation of the letter “I”), with palms facing inward.  Keep your head aligned with your upper spine. Focus on generating most of your lift through your shoulders and not the low back although some low back extension (arching) is acceptable.  Hold this position for 5 – 10 seconds then relax and return to your starting position.  Perform 2 – 4 repetitions.\n" +
            "Step 3: “Y” Formation: From the same starting position, gently exhale and slowly lift your arms off the floor, moving your arms into the “Y” formation (45-degree angle to form the letter “Y”) as illustrated with palms facing inward.  Maintain your head alignment with your upper spine.  Focus on generating most of your lift through your shoulders and not the low back although some low back extension (arching) is acceptable.  Hold this position for 5 – 10 seconds then relax and return to your starting position.  Perform 2 – 4 repetitions.\n" +
            "Step 4: “T” Formation: From the same starting position, gently exhale and slowly lift your arms off the floor, moving your arms into the “T” formation (90-degree angle to form the letter “T”) as illustrated with palms facing forward.  Maintain your head alignment with your upper spine. Focus on generating most of your lift through your shoulders and not the low back although some low back extension (arching) is acceptable.  Hold this position for 5 – 10 seconds then relax and return to your starting position.  Perform 2 – 4 repetitions.\n" +
            "Step 5: “W” Formation: From the same starting position, gently exhale and slowly lift your arms off the floor, flexing (bending) your elbows and dropping them to a 45-degree angle to the sides of your body as illustrated with palms facing inward (“W” formation to form the letter “W”).  Maintain your head alignment with your upper spine. Focus on generating most of your lift through your shoulders and not the low back although some low back extension (arching) is acceptable.  Hold this position for 5 – 10 seconds then relax and return to your starting position.  Perform 2 – 4 repetitions.\n" +
            "Step 6: “O” Formation: From a position with arms at your sides, gently exhale and elevate your shoulders while internally rotating both arms as if reaching behind to scratch your back.  Overlap your hands in the small of your back into an “O” formation (form the letter “O”).  Maintain your head alignment with your upper spine. Focus on generating most of your lift through your shoulders and not the low back although some low back extension (arching) is acceptable.  Hold this position for 5 – 10 seconds then relax and return to your starting position.  Perform 2 – 4 repetitions.\n";
    String desc15 = "Step 1: Starting Position: Lie on your side on a mat with both legs extended so that your hips and shoulder are aligned vertically with the floor and your spine and head are in alignment. Bend your upper leg to create a 90-degree bend at both the hip and knee, resting the inside of that knee upon the mat or upon a raised platform, Extend both arms out directly in front you at chest level, overlapping your fingers together.  \n" +
            "Step 2: Stiffen your abdominal muscles to stabilize your spine in a neutral position and maintain this throughout the exercise. Gently exhale and slowly rotate your trunk and upper arm until your belly button faces the ceiling and your upper arm extends out to the side, either touching or being elevated slightly above the floor. \n" +
            "Step 3: Pull shoulders back and down without moving your trunk and attempt to hold this position throughout the exercise.  Hold this position briefly, then flex (bend) the elbow of the lower arm so that the back of the arm rests against the floor / mat, while the forearm is aligned vertically to the floor.   Extend the other arm vertically towards the ceiling, but do not allow the scapula to move.\n" +
            "Step 4: Gently exhale and while stabilizing your scapulae (shoulder blades), trunk and hips, perform a series of push-pull movements with your arms: Press the lower arm upwards, extending the elbow without allowing the scapula to move forward. Pull the upper arm downwards towards the chest, flexing (bending) the elbow without allowing the scapula to move backwards.\n";
    String desc16 = "Step 1: Starting Position: Kneel on an exercise mat or floor, positioning your knees and feet hip-width apart, with your toes pointing towards your body. Slowly lean forward to place your hands on the floor slightly in front of your shoulders, fingers pointing forwards.  Flex your left hip, bringing your left thigh to your chest, placing your left foot on the floor, heel slighlty lifted and toes pointing forward.  Lift your right knee off the ground, fully extending your right leg behind you, with your toes pointing towards your shins, heel up. Stiffen your abdominal muscles to stabilize your spine, then pull your shoulders down and back.\n" +
            "Step 2: Keeping your hands firmly on the ground, abs engaged and shoulder strong, simultaneously switch leg positions.  Both feet leave the ground as your drive your right knee forward and extend your left leg back.  Now your left leg is fully extending behind you and your right hip is flexed with your right foot on the floor.\n";
    String desc17 = "Step 1: Starting Position: Lie on your back on an exercise mat or firm surface, bending your knees until your feet are positioned flat on the floor. Place your arms at your sides, with elbows fully extended and palms facing inward. Breathe deeply for 30 seconds relaxing your body and allowing gravity to gently pull your lower back and shoulders towards the floor.\n" +
            "Step 2: Pull your shoulder down and back without increasing the arch in your low back or lifting your hips off the mat / floor. Contract your abdominal / core muscles to flatten your low back into the mat and hold this position throughout the exercise.\n" +
            "Step 3: Slide your arms out from your sides forming a 45-degree angle with your torso, keeping your upper arms making contact with the mat / floor. Bend your elbows to a comfortable position and keep your wrists in a neutral position.\n" +
            "Step 4: Upward Movement: Exhale and gently rotate your upper arms, sliding the mat / floor to an end position where your hands touch overhead, and your elbows have a comfortable bend. Attempt to keep much of the back of your upper arms, forearms, wrists and hands in contact with, or near the mat/ floor and avoid arching your lower back as your rotate overhead.\n" +
            "Step 5: Downward Movement: Inhale and gently rotate your arms back to your starting position, attempting to keep your upper arms, forearms, wrists and hands in contact with, or near the mat/ floor and avoid arching your lower back as your rotate overhead.\n";
    String desc18 = "Step 1: Starting Position:  From a standing position with your feet together or slightly apart, stiffen your abdominal muscles to stabilize your spine.   \n" +
            "Step 2: Gently exhale and bend forward from your hips, keeping your knees extended, and extend your arms in front of your body while slowly lowering your torso towards the floor until you can place your fingers or palms of your hands on the floor in front of your body.  Maintaining a flat spine and a soft bend in your knees during this movement is acceptable.\n" +
            "Step 3: Slowly begin to walk your hands forward without moving your feet. Continue walking yourself forward until you reach a full-push-up position where your spine, hips and head are level with the floor.\n" +
            "Step 4: Perform one full push-up, lowering your chest and hips simultaneously to the floor while maintaining a rigid torso and head aligned with your spine.  Do not allow your low back to sag or your hips to hike upwards during this downward phase.  Continue to lower yourself until your chest or chin touch the floor. Allow your elbows to flare outwards during the lowering phase.   \n" +
            "Step 5: Press upwards through your arms while maintaining a rigid torso and head aligned with your spine.  Do not allow your low back to sag or your hips to hike upwards. Continue pressing until the arms fully extend at the elbows.  Slowly begin walking your feet forward towards your hands. Maintain a flat spine throughout and continue walking until your feet are close to your hands.  \n" +
            "Step 6: Repeat this movement and cotinue for 9-13 metres.\n";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        trainingViewModel =
                new ViewModelProvider(this).get(TrainingViewModel.class);

        binding = FragmentTrainingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


       crunches = binding.crunchesBtn;
       plank = binding.sidePlankBtn;
       Biceps = binding.BicepsStretch;
       Cobra = binding.Cobra;
       CKC = binding.CKC;
       Calf = binding.Calf;
       Neck = binding.NeckFlexion;
       superman = binding.supermans;
       sumo = binding.SumoSquat;
       sidePl = binding.SidePlLEgs;
       HighPl = binding.HighPlank;
       pushup = binding.PushUps;
       pushleg = binding.PushLegs;
       Prone = binding.Prone;
       Twist = binding.Twist;
       climbers = binding.Climbers;
       supine = binding.SupineSnow;
       inchWorms = binding.InchWorm;




        crunches.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Crunches", desc, 12000, R.drawable.crunches));
                fr.commit();
                SetInvisible();

            }
        });

        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Side Plank",desc2 , 30000, R.drawable.sideplank));
                fr.commit();
                SetInvisible();
            }
        });

        Biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Seated Bent-Knee Biceps Stretch",desc3 , 30000, R.drawable.seated_bent_knee_biceps_stretch));
                fr.commit();
                SetInvisible();
            }
        });
        Cobra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Cobra", desc4, 30000, R.drawable.cobra_exercise));
                fr.commit();
                SetInvisible();
            }
        });

        CKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("CKC", desc5, 30000, R.drawable.ckc_parascapular));
                fr.commit();
                SetInvisible();
            }
        });

        Calf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Standing Calf Raises", desc6, 30000, R.drawable.calfraises));
                fr.commit();
                SetInvisible();
            }
        });

        Neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Leteral Neck Flexion", desc7, 30000, R.drawable.lateral_neck_flexion));
                fr.commit();
                SetInvisible();
            }
        });

        superman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Supermans", desc8, 30000, R.drawable.supermans));
                fr.commit();
                SetInvisible();
            }
        });
        sumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Sumo Rotational Squats", desc9, 30000, R.drawable.sumo_rotational_squats));
                fr.commit();
                SetInvisible();
            }
        });
        sidePl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Side Plank with Straight Leg ", desc10, 30000, R.drawable.sideplank)); // NETINKAMAS VIDEO
                fr.commit();
                SetInvisible();
            }
        });
        HighPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("High Plank T-spine Rotation ", desc11, 30000, R.drawable.high_plank_t_spine_rotation));
                fr.commit();
                SetInvisible();
            }
        });
        pushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Push-up ", desc12, 30000, R.drawable.push_up));
                fr.commit();
                SetInvisible();
            }
        });

        pushleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Push-up with Single-leg Raise ", desc13, 30000, R.drawable.push_up_with_single_leg_raise));
                fr.commit();
                SetInvisible();
            }
        });

        Prone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Prone scapular stabilization series ", desc14, 30000, R.drawable.prone_scapular_stabilization_series));
                fr.commit();
                SetInvisible();
            }
        });

        Twist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Spinal Twist with a Push-Pull Movement  ", desc15, 30000, R.drawable.spinal_twist_with_a_push_pull_movement));
                fr.commit();
                SetInvisible();
            }
        });

        climbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Mountain Climbers  ", desc16, 30000, R.drawable.mountain_climbers));
                fr.commit();
                SetInvisible();
            }
        });

        supine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Supine Snow Angel ", desc17, 30000, R.drawable.push_up)); //NETINKAMAS VIDEO
                fr.commit();
                SetInvisible();
            }
        });

        inchWorms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Inchworms", desc18, 30000, R.drawable.inchworms));
                fr.commit();
                SetInvisible();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void SetInvisible() {
        crunches.setVisibility(View.INVISIBLE);
        plank.setVisibility(View.INVISIBLE);
        Biceps.setVisibility(View.INVISIBLE);
        Cobra.setVisibility(View.INVISIBLE);
        CKC.setVisibility(View.INVISIBLE);
        Calf.setVisibility(View.INVISIBLE);
        Neck.setVisibility(View.INVISIBLE);
        superman.setVisibility(View.INVISIBLE);
        sumo.setVisibility(View.INVISIBLE);
        sidePl.setVisibility(View.INVISIBLE);
        HighPl.setVisibility(View.INVISIBLE);
        pushup.setVisibility(View.INVISIBLE);
        pushleg.setVisibility(View.INVISIBLE);
        Prone.setVisibility(View.INVISIBLE);
        Twist.setVisibility(View.INVISIBLE);
        climbers.setVisibility(View.INVISIBLE);
        supine.setVisibility(View.INVISIBLE);
        inchWorms.setVisibility(View.INVISIBLE);
    }

}
